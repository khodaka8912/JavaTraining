package ch16.ex16_09;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.List;

public class ClassContents {

	private static class Block {
		private static final String INDENT = "  ";

		private int indent = 0;
		private String decl;
		private final List<Object> contents = new ArrayList<>();

		Block(String decl) {
			this.decl = decl;
		}

		void add(String statement) {
			if (!statement.endsWith(";")) {
				statement += ";";
			}
			contents.add(statement);
		}

		void add(Block block) {
			contents.add(block);
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			indent(sb, indent).append(decl).append(" {\n");
			for (Object content : contents) {
				if (content instanceof String) {
					String statement = (String) content;
					indent(sb, indent + 1).append(statement).append("\n");
				} else if (content instanceof Block) {
					Block block = (Block) content;
					block.indent = this.indent + 1;
					sb.append(block).append("\n");
				} else {
					throw new AssertionError();
				}
			}
			indent(sb, indent).append("}");
			return sb.toString();
		}
		
		private StringBuilder indent(StringBuilder sb, int indent) {
			for (int i = 0; i < indent; i++) {
				sb.append(INDENT);
			}
			return sb;
		}
	}

	public static void main(String[] args) {
		try {
			Class<?> c = Class.forName(args[0]);
			showClassDeclaration(c);
		} catch (ClassNotFoundException e) {
			System.out.println("unknown class: " + args[0]);
		}
	}

	private static void showClassDeclaration(Class<?> cls) {
		showPackage(cls);
		System.out.println(getClassDeclaration(cls));
	}

	private static void showPackage(Class<?> cls) {
		Package pkg = cls.getPackage();
		if (pkg != null) {
			System.out.println(	getAnnotations(pkg) + "package " + pkg.getName() + ";");
		}
	}

	private static Block getClassDeclaration(Class<?> cls) {
		StringBuilder sb = new StringBuilder();
		sb.append(getAnnotations(cls));
		sb.append(getModifiers(cls.getModifiers()));
		if (Modifier.isInterface(cls.getModifiers())) {
			sb.append("interface ");
		} else {
			sb.append("class ");
		}
		sb.append(cls.getSimpleName()).append(getTypeParameters(cls.getTypeParameters())).append(getSuperTypes(cls));

		Block classBlock = new Block(sb.toString());

		for (String field: getFields(cls)) {
			classBlock.add(field);			
		}

		for (String medhod : getMethods(cls)) {
			classBlock.add(medhod);
		}

		Class<?>[] innerClasses = cls.getDeclaredClasses();
		for (Class<?> innerClass : innerClasses) {
			if (innerClass.getCanonicalName() != null) {
				classBlock.add(getClassDeclaration(innerClass));
			}
		}
		return classBlock;
	}


	private static String getSuperTypes(Class<?> cls) {
		StringBuilder sb = new StringBuilder();
		Type superType = cls.getGenericSuperclass();
		if (superType != null && superType != Object.class) {
			sb.append(" extends ").append(getGenericType(superType));
		}

		Type[] interfaces = cls.getGenericInterfaces();
		if (interfaces.length > 0) {
			sb.append(" implements ");
			for (Type iface : interfaces) {
				sb.append(getGenericType(iface)).append(", ");
			}
			sb.delete(sb.length() - 2, sb.length());
		}
		return sb.toString();
	}

	private static String getGenericType(Type type) {
		StringBuilder sb = new StringBuilder();
		if (type instanceof Class<?>) {
			Class<?> cls = (Class<?>) type;
			sb.append(cls.getSimpleName());
		} else if (type instanceof ParameterizedType) {
			ParameterizedType paramType = (ParameterizedType) type;
			sb.append(((Class<?>) paramType.getRawType()).getSimpleName());
			sb.append(getTypeParameters(paramType.getActualTypeArguments()));
		} else if (type instanceof TypeVariable) {
			sb.append(((TypeVariable<?>) type).getName());
		} else if (type instanceof WildcardType) {
			WildcardType wildcard = (WildcardType) type;
			sb.append("?");
			Type[] uppers = wildcard.getUpperBounds();
			if (uppers.length > 0) {
				sb.append(" extends ");
				for (Type upperType : uppers) {
					sb.append(getGenericType(upperType)).append(", ");
				}
				sb.delete(sb.length() - 2, sb.length());
			}
			Type[] lowers = wildcard.getLowerBounds();
			if (lowers.length > 0) {
				sb.append(" super ");
				for (Type lowerType : lowers) {
					sb.append(getGenericType(lowerType)).append(", ");
				}
				sb.delete(sb.length() - 2, sb.length());
			}
		}
		return sb.toString();
	}

	private static String[] getFields(Class<?> cls) {
		Field[] fields = cls.getDeclaredFields();
		List<String> fieldList = new ArrayList<>();
		for (Field field : fields) {
			// エンクロージングクラスへの参照は表示しない
			if (field.getName().startsWith("this")) {
				continue;
			}
			fieldList.add(getField(field));
		}
		
		return fieldList.toArray(new String[fieldList.size()]);
	}
	
	private static String getField(Field field) {
		StringBuilder sb = new StringBuilder();
		sb.append(getAnnotations(field))
		.append(getModifiers(field.getModifiers()))
		.append(getGenericType(field.getGenericType()))
		.append(" ")
		.append(field.getName())
		.append(";");
		return sb.toString();
	}

	private static String[] getMethods(Class<?> cls) {
		Method[] methods = cls.getDeclaredMethods();
		String[] statements = new String[methods.length];
		for (int i = 0; i < methods.length; i++) {
			statements[i] = getMethod(methods[i]);
		}
		return statements;
	}

	private static String getMethod(Method method) {
		StringBuilder sb = new StringBuilder();
		sb.append(getAnnotations(method))
		.append(getModifiers(method.getModifiers()))
		.append(getTypeParameters(method.getTypeParameters()))
		.append(getGenericType(method.getGenericReturnType()))
		.append(" ")
		.append(method.getName())
		.append("(");
		Type[] paramTypes = method.getGenericParameterTypes();
		if (paramTypes.length > 0) {
			Annotation[][] paramAnnotations = method.getParameterAnnotations();
		for (int i = 0; i < paramTypes.length; i++) {
			Type paramType = paramTypes[i];
			Annotation[] annotations = paramAnnotations[i];
			sb.append(getAnnotations(annotations))
			.append(getGenericType(paramType))
			.append(" param")
			.append(i + 1)
			.append(", ");
		}
		sb.delete(sb.length() - 2, sb.length());
		}
		sb.append(")");
		Type[] eTypes = method.getGenericExceptionTypes();
		if (eTypes.length > 0) {
			sb.append(" throws ");
			for (Type eType : eTypes) {
				Class<?> eClass = (Class<?>) eType;
				sb.append(eClass.getSimpleName()).append(", ");
			}
			sb.delete(sb.length() - 2, sb.length());
		}
		return sb.append(";").toString();
	}

	private static String getTypeParameters(Type[] params) {
		if (params.length == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		for (Type param : params) {
			sb.append(getGenericType(param)).append(", ");
		}
		sb.delete(sb.length() - 2, sb.length()).append(">");
		return sb.toString();
	}

	private static String getAnnotations(AnnotatedElement element) {
		return getAnnotations(element.getAnnotations());

	}
	
	private static String getAnnotations(Annotation[] annotations) {
		StringBuilder sb = new StringBuilder();
		for (Annotation annotation : annotations) {
			sb.append(annotation.toString()).append(" ");
		}
		return sb.toString();
	}

	private static String getModifiers(int mod) {
		StringBuilder sb = new StringBuilder();
		if (Modifier.isPublic(mod)) {
			sb.append("public ");
		} else if (Modifier.isProtected(mod)) {
			sb.append("protected ");
		} else if (Modifier.isPrivate(mod)) {
			sb.append("private ");
		}
		if (Modifier.isAbstract(mod)) {
			sb.append("abstract ");
		}
		if (Modifier.isStatic(mod)) {
			sb.append("static ");
		}
		if (Modifier.isFinal(mod)) {
			sb.append("final ");
		}
		if (Modifier.isTransient(mod)) {
			sb.append("transient ");
		}
		if (Modifier.isVolatile(mod)) {
			sb.append("volatile ");
		}
		if (Modifier.isSynchronized(mod)) {
			sb.append("synchronized ");
		}
		if (Modifier.isNative(mod)) {
			sb.append("native ");
		}
		if (Modifier.isStrict(mod)) {
			sb.append("strictfp ");
		}
		return sb.toString();
	}

}
