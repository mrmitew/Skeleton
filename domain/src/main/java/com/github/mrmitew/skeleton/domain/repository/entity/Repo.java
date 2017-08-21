package com.github.mrmitew.skeleton.domain.repository.entity;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Repo {
    public abstract int getId();

    public abstract String getName();

    public abstract String getUrl();

    public static Builder builder() {
        return new AutoValue_Repo.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder setId(final int newId);

        public abstract Builder setName(final String newName);

        public abstract Builder setUrl(final String newUrl);

        public abstract Repo build();
    }
}