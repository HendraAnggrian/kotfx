package ktfx.listeners

import javafx.scene.control.ScrollToEvent
import javafx.scene.control.SortEvent
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import io.github.hendraanggrian.ktfx.test.BaseTableViewTest

class TableViewTest : BaseTableViewTest() {

    override fun <S> TableView<S>.callOnSort(action: (SortEvent<TableView<S>>) -> Unit) = onSort(action)
    override fun <S> TableView<S>.callOnScrollTo(action: (ScrollToEvent<Int>) -> Unit) = onScrollTo(action)
    override fun <S> TableView<S>.callOnScrollToColumn(action: (ScrollToEvent<TableColumn<S, *>>) -> Unit) =
        onScrollToColumn(action)
}