package com.siimkinks.sqlitemagic.model.immutable;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.siimkinks.sqlitemagic.Utils;
import com.siimkinks.sqlitemagic.annotation.Id;
import com.siimkinks.sqlitemagic.annotation.IgnoreColumn;
import com.siimkinks.sqlitemagic.annotation.Table;
import com.siimkinks.sqlitemagic.model.Author;

import java.util.Random;

@AutoValue
@Table(persistAll = true)
public abstract class BuilderMagazine implements ImmutableEquals {
  public static final String TABLE = "builder_magazine";
  public static final String C_ID = "builder_magazine.id";
  public static final String C_NAME = "builder_magazine.name";
  public static final String C_AUTHOR = "builder_magazine.author";
  public static final String C_SIMPLE_VALUE_WITH_BUILDER = "builder_magazine.simple_value_with_builder";
  public static final String C_SIMPLE_VALUE_WITH_CREATOR = "builder_magazine.simple_value_with_creator";

  @Id
  public abstract long id();

  @Nullable
  public abstract String name();

  @Nullable
  public abstract Author author();

  @Nullable
  public abstract SimpleValueWithBuilder simpleValueWithBuilder();

  @Nullable
  public abstract SimpleValueWithCreator simpleValueWithCreator();

  @IgnoreColumn
  public abstract Builder copy();

  public static Builder builder() {
    return new AutoValue_BuilderMagazine.Builder();
  }

  public boolean equalsWithoutId(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof BuilderMagazine) {
      BuilderMagazine that = (BuilderMagazine) o;
      return ((this.name() == null) ? (that.name() == null) : this.name().equals(that.name()))
          && ((this.author() == null) ? (that.author() == null) : this.author().equals(that.author()))
          && ((this.simpleValueWithBuilder() == null) ? (that.simpleValueWithBuilder() == null) : this.simpleValueWithBuilder().equalsWithoutId(that.simpleValueWithBuilder()))
          && ((this.simpleValueWithCreator() == null) ? (that.simpleValueWithCreator() == null) : this.simpleValueWithCreator().equalsWithoutId(that.simpleValueWithCreator()));
    }
    return false;
  }

  @AutoValue.Builder
  public static abstract class Builder {
    public abstract Builder id(long id);

    public abstract Builder name(String name);

    public abstract Builder author(Author author);

    public abstract Builder simpleValueWithBuilder(SimpleValueWithBuilder simpleValueWithBuilder);

    public abstract Builder simpleValueWithCreator(SimpleValueWithCreator simpleValueWithCreator);

    public abstract BuilderMagazine build();
  }

  public static Builder newRandom() {
    final Random r = new Random();
    return builder()
        .id(r.nextLong())
        .name(Utils.randomTableName())
        .author(Author.newRandom())
        .simpleValueWithBuilder(SimpleValueWithBuilder.newRandom().build())
        .simpleValueWithCreator(SimpleValueWithCreator.newRandom());
  }

  @Override
  public Long provideId() {
    return id();
  }
}