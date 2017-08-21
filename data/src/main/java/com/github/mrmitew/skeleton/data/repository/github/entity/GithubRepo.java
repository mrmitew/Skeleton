package com.github.mrmitew.skeleton.data.repository.github.entity;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

@AutoValue
public abstract class GithubRepo {
    public abstract int getId();

    public abstract String getName();

    @SerializedName("full_name")
    public abstract String getFullName();

    public abstract String getUrl();

    public static TypeAdapter<GithubRepo> typeAdapter(Gson gson) {
        return new AutoValue_GithubRepo.GsonTypeAdapter(gson);
    }

    public static Builder builder() {
        return new AutoValue_GithubRepo.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder setId(final int newId);

        public abstract Builder setName(final String newName);

        public abstract Builder setFullName(final String newFullName);

        public abstract Builder setUrl(final String newUrl);

        public abstract GithubRepo build();
    }
}
