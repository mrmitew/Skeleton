package com.github.mrmitew.skeleton.adapter.base.view.welcome;

import com.github.mrmitew.skeleton.adapter.base.view.welcome.interactor.GetRepoListUseCaseDecorator;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WelcomePresenterTest {
    @Mock
    RepoSearchView mRepoSearchView;

    @Mock
    GetRepoListUseCaseDecorator mGetRepoListUseCaseDecorator;

    private WelcomePresenter mWelcomePresenter;

    @Before
    public void setUp() throws Exception {
        mWelcomePresenter =
                new WelcomePresenter(mRepoSearchView, mGetRepoListUseCaseDecorator);
    }

    // TODO: 8/21/17
}