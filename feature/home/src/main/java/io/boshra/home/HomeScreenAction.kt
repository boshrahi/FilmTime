package io.boshra.home

sealed class HomeScreenAction {
  data object RefreshScreen : HomeScreenAction()
}
