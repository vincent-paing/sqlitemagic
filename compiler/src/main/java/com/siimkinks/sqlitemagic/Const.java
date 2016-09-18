package com.siimkinks.sqlitemagic;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.siimkinks.sqlitemagic.element.ExtendedTypeElement;
import com.siimkinks.sqlitemagic.transformer.BooleanTransformer;
import com.siimkinks.sqlitemagic.transformer.DateTransformer;
import com.squareup.javapoet.TypeName;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.lang.model.element.Modifier;
import javax.lang.model.type.TypeMirror;

import static javax.lang.model.element.Modifier.ABSTRACT;
import static javax.lang.model.element.Modifier.FINAL;
import static javax.lang.model.element.Modifier.PRIVATE;
import static javax.lang.model.element.Modifier.PUBLIC;
import static javax.lang.model.element.Modifier.STATIC;
import static javax.lang.model.element.Modifier.SYNCHRONIZED;

public class Const {
	public static final Modifier[] CLASS_MODIFIERS = new Modifier[]{PUBLIC, FINAL};
	public static final Modifier[] INNER_ABSTRACT_CLASS_MODIFIERS = new Modifier[]{PUBLIC, STATIC, ABSTRACT};
	public static final Modifier[] PUBLIC_STATIC_FINAL = new Modifier[]{PUBLIC, STATIC, FINAL};
	public static final Modifier[] PUBLIC_FINAL = new Modifier[]{PUBLIC, FINAL};
	public static final Modifier[] STATIC_METHOD_MODIFIERS = new Modifier[]{PUBLIC, STATIC};
	public static final Modifier[] PRIVATE_FINAL_FIELD_MODIFIERS = new Modifier[]{PRIVATE, FINAL};
	public static final Modifier[] PRIVATE_STATIC_METHOD_MODIFIERS = new Modifier[]{PRIVATE, STATIC};
	public static final Modifier[] METHOD_MODIFIERS_WITH_SYNC = new Modifier[]{PUBLIC, STATIC, SYNCHRONIZED};

	public static final String GENERATION_COMMENT = "Generated by SqliteMagic. Do not modify!";
	public static final String DEFAULT_ID_COLUMN_NAME = "_id";
	public static final String DEFAULT_ID_FIELD_NAME = "id";
	public static final String DEFAULT_ID_SCHEMA = DEFAULT_ID_COLUMN_NAME + " INTEGER PRIMARY KEY AUTOINCREMENT";

	public static TypeMirror OBJECT_TYPE;
	public static TypeMirror LONG_TYPE;
	public static TypeMirror BYTE_TYPE;
	public static TypeMirror BOOLEAN_TYPE;
	public static TypeMirror NUMBER_TYPE;
	public static TypeMirror CHAR_SEQUENCE_TYPE;
	public static TypeMirror STRING_TYPE;
	public static TypeMirror COMPILED_SELECT;

	public static final Map<String, String> SQL_TYPE_MAP = new HashMap<String, String>() {
		{
			put(byte[].class.getCanonicalName(), "BLOB");
			put(Byte[].class.getCanonicalName(), "BLOB");
			put(byte.class.getCanonicalName(), "BLOB");
			put(Byte.class.getCanonicalName(), "BLOB");
			put(double.class.getCanonicalName(), "REAL");
			put(Double.class.getCanonicalName(), "REAL");
			put(float.class.getCanonicalName(), "REAL");
			put(Float.class.getCanonicalName(), "REAL");
			put(int.class.getCanonicalName(), "INTEGER");
			put(Integer.class.getCanonicalName(), "INTEGER");
			put(long.class.getCanonicalName(), "INTEGER");
			put(Long.class.getCanonicalName(), "INTEGER");
			put(short.class.getCanonicalName(), "INTEGER");
			put(Short.class.getCanonicalName(), "INTEGER");
			put(String.class.getCanonicalName(), "TEXT");
		}
	};

	public static final Map<String, String> NUMERIC_SQL_TYPE_MAP = new HashMap<String, String>() {
		{
			put(double.class.getCanonicalName(), "REAL");
			put(Double.class.getCanonicalName(), "REAL");
			put(float.class.getCanonicalName(), "REAL");
			put(Float.class.getCanonicalName(), "REAL");
			put(int.class.getCanonicalName(), "INTEGER");
			put(Integer.class.getCanonicalName(), "INTEGER");
			put(long.class.getCanonicalName(), "INTEGER");
			put(Long.class.getCanonicalName(), "INTEGER");
			put(short.class.getCanonicalName(), "INTEGER");
			put(Short.class.getCanonicalName(), "INTEGER");
		}
	};

	public static final Map<String, String> CURSOR_GETTER_CAST_MAP = new HashMap<String, String>() {
		{
			put(byte.class.getCanonicalName(), "(byte)");
			put(Byte.class.getCanonicalName(), "(byte)");
		}
	};

	public static final Map<String, String> CURSOR_GETTER_FIELD_NAMES = new HashMap<String, String>() {
		{
			put(byte[].class.getCanonicalName(), "UNBOXED_BYTE_ARRAY_PARSER");
			put(Byte[].class.getCanonicalName(), "BOXED_BYTE_ARRAY_PARSER");
			put(double.class.getCanonicalName(), "DOUBLE_PARSER");
			put(Double.class.getCanonicalName(), "DOUBLE_PARSER");
			put(float.class.getCanonicalName(), "FLOAT_PARSER");
			put(Float.class.getCanonicalName(), "FLOAT_PARSER");
			put(int.class.getCanonicalName(), "INTEGER_PARSER");
			put(Integer.class.getCanonicalName(), "INTEGER_PARSER");
			put(long.class.getCanonicalName(), "LONG_PARSER");
			put(Long.class.getCanonicalName(), "LONG_PARSER");
			put(short.class.getCanonicalName(), "SHORT_PARSER");
			put(Short.class.getCanonicalName(), "SHORT_PARSER");
			put(byte.class.getCanonicalName(), "BYTE_PARSER");
			put(Byte.class.getCanonicalName(), "BYTE_PARSER");
			put(String.class.getCanonicalName(), "STRING_PARSER");
		}
	};

	@Nullable
	public static String cursorParserConstantName(@NonNull ExtendedTypeElement serializedType, @NonNull Environment environment) {
		if (serializedType.isPrimitiveByteArray(environment)) {
			return "UNBOXED_BYTE_ARRAY_PARSER";
		}
		final String qualifiedName = serializedType.getQualifiedName();
		return Const.CURSOR_GETTER_FIELD_NAMES.get(qualifiedName);
	}

	public static final Map<String, String> CURSOR_METHOD_MAP = new HashMap<String, String>() {
		{
			put(byte[].class.getCanonicalName(), "getBlob");
			put(Byte[].class.getCanonicalName(), "getBlob");
			put(double.class.getCanonicalName(), "getDouble");
			put(Double.class.getCanonicalName(), "getDouble");
			put(float.class.getCanonicalName(), "getFloat");
			put(Float.class.getCanonicalName(), "getFloat");
			put(int.class.getCanonicalName(), "getInt");
			put(Integer.class.getCanonicalName(), "getInt");
			put(long.class.getCanonicalName(), "getLong");
			put(Long.class.getCanonicalName(), "getLong");
			put(short.class.getCanonicalName(), "getShort");
			put(Short.class.getCanonicalName(), "getShort");
			put(byte.class.getCanonicalName(), "getLong");
			put(Byte.class.getCanonicalName(), "getLong");
			put(String.class.getCanonicalName(), "getString");
		}
	};

	public static final Map<TypeName, String> PRIMITIVES_DEFAULT_VALUE_MAP = new HashMap<TypeName, String>() {
		{
			put(TypeName.BOOLEAN, "false");
			put(TypeName.BYTE, "0");
			put(TypeName.SHORT, "0");
			put(TypeName.INT, "0");
			put(TypeName.LONG, "0L");
			put(TypeName.CHAR, "'\\u0000'");
			put(TypeName.FLOAT, "0.0f");
			put(TypeName.DOUBLE, "0.0d");
		}
	};
	public static final Map<String, String> STATEMENT_METHOD_MAP = new HashMap<String, String>() {
		{
			put(byte[].class.getCanonicalName(), "bindBlob");
			put(Byte[].class.getCanonicalName(), "bindBlob");
			put(double.class.getCanonicalName(), "bindDouble");
			put(Double.class.getCanonicalName(), "bindDouble");
			put(float.class.getCanonicalName(), "bindDouble");
			put(Float.class.getCanonicalName(), "bindDouble");
			put(int.class.getCanonicalName(), "bindLong");
			put(Integer.class.getCanonicalName(), "bindLong");
			put(long.class.getCanonicalName(), "bindLong");
			put(Long.class.getCanonicalName(), "bindLong");
			put(short.class.getCanonicalName(), "bindLong");
			put(Short.class.getCanonicalName(), "bindLong");
			put(byte.class.getCanonicalName(), "bindLong");
			put(Byte.class.getCanonicalName(), "bindLong");
			put(String.class.getCanonicalName(), "bindString");
		}
	};

	public static final List<String> DEFAULT_TRANSFORMERS = new LinkedList<String>() {
		{
			add(BooleanTransformer.class.getCanonicalName());
			add(DateTransformer.class.getCanonicalName());
		}
	};

	public static final List<String> SUPPORTED_SQL_BOXED_TYPES = Arrays.asList(
			Long.class.getSimpleName(), Integer.class.getSimpleName(), Short.class.getSimpleName(),
			Double.class.getSimpleName(), Float.class.getSimpleName(), Byte[].class.getSimpleName(),
			Byte.class.getSimpleName(), String.class.getSimpleName()
	);

	public static void init(Environment environment) {
		OBJECT_TYPE = environment.getTypeElement(Object.class).asType();
		LONG_TYPE = environment.getTypeElement(Long.class).asType();
		BYTE_TYPE = environment.getTypeElement(Byte.class).asType();
		BOOLEAN_TYPE = environment.getTypeElement(Boolean.class).asType();
		NUMBER_TYPE = environment.getTypeElement(Number.class).asType();
		CHAR_SEQUENCE_TYPE = environment.getTypeElement(CharSequence.class).asType();
		STRING_TYPE = environment.getTypeElement(String.class).asType();
		COMPILED_SELECT = environment.getTypeElement(CompiledSelect.class).asType();
	}

	public static final String ERR_TRANSFORM_TYPES_NOT_MATCHING = "One transformer method's return type must be the same as other method's first parameter and vice versa";
	public static final String ERR_MULTIPLE_TRANSFORMERS = "Multiple transformers for ";
}
