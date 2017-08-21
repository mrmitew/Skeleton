package com.github.mrmitew.skeleton.adapter.base.view.welcome;

import com.github.mrmitew.skeleton.domain.repository.entity.Repo;
import com.google.auto.value.AutoValue;

import java.util.List;

interface RenderVisitorAcceptor {
    void accept(RepoListViewState.RenderVisitor visitor);
}

public interface RepoListViewState extends RenderVisitorAcceptor {
    interface RenderVisitor {
        void visit(RepoListViewState.SearchNotStartedYet state);

        void visit(RepoListViewState.Loading state);

        void visit(RepoListViewState.EmptyResult state);

        void visit(RepoListViewState.SearchResult state);

        void visit(RepoListViewState.Error state);
    }
    
    final class SearchNotStartedYet implements RepoListViewState {
        @Override
        public void accept(RenderVisitor stateVisitor) {
            stateVisitor.visit(this);
        }
    }

    final class Loading implements RepoListViewState {
        @Override
        public void accept(RenderVisitor stateVisitor) {
            stateVisitor.visit(this);
        }
    }

    @AutoValue
    abstract class EmptyResult implements RepoListViewState {
        public abstract String getSearchQueryText();

        @Override
        public void accept(RenderVisitor stateVisitor) {
            stateVisitor.visit(this);
        }

        public static EmptyResult create(final String newSearchQueryText) {
            return new AutoValue_RepoListViewState_EmptyResult(newSearchQueryText);
        }
    }

    @AutoValue
    abstract class SearchResult implements RepoListViewState {
        public abstract String getSearchQueryText();

        public abstract List<Repo> getRepoList();

        @Override
        public void accept(RenderVisitor stateVisitor) {
            stateVisitor.visit(this);
        }

        public static SearchResult create(final String newSearchQueryText,
                                          final List<Repo> newRepoList) {
            return new AutoValue_RepoListViewState_SearchResult(newSearchQueryText, newRepoList);
        }
    }

    @AutoValue
    abstract class Error implements RepoListViewState {
        public abstract String getSearchQueryText();

        public abstract Throwable getError();

        @Override
        public void accept(RenderVisitor stateVisitor) {
            stateVisitor.visit(this);
        }

        public static Error create(final String newSearchQueryText, final Throwable newError) {
            return new AutoValue_RepoListViewState_Error(newSearchQueryText, newError);
        }
    }
}