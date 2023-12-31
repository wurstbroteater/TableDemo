package de.ufo.tracktable;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableView;
import javafx.scene.control.skin.TableViewSkin;
import javafx.stage.Window;

/**
 * Taken from <a href="https://stackoverflow.com/questions/55461094/sync-scrollbars-for-two-tableviews-not-working-with-empty-table">stackoverflow</a>
 *
 * @param <T>
 */
public class CustomTableSkin<T> extends TableViewSkin<T> {

    private boolean forceNotEmpty = false;

    ChangeListener<Boolean> showingListener = (src, ov, nv) -> initForceNotEmpty(src);

    public CustomTableSkin(TableView<T> control) {
        super(control);

        Window window = getSkinnable().getScene().getWindow();
        if (window != null)
            window.showingProperty().addListener(showingListener);
    }

    /**
     * Overridden to force a re-layout with faked itemCount after calling
     * super if the fake flag is true.
     */
    @Override
    protected void layoutChildren(double x, double y, double w, double h) {
        super.layoutChildren(x, y, w, h);
        if (forceNotEmpty) {
            forceNotEmptyLayout();
        }
    }

    /**
     * Callback from listener installed on window's showing property.
     * Implemented to set the forceNotEmpty flag and remove the listener.
     */
    private void initForceNotEmpty(ObservableValue<?> src) {
        forceNotEmpty = true;
        src.removeListener((InvalidationListener) showingListener);
    }

    /**
     * Enforces a layout pass on the flow with at least one row.
     * Resets the forceNotEmpty flag and triggers a second
     * layout pass with the correct count.
     */
    private void forceNotEmptyLayout() {
        if (!forceNotEmpty) return;
        updateItemCount();
        forceNotEmpty = false;
        updateItemCount();
    }

    /**
     * Overridden to return at least 1 if forceNotEmpty is true.
     */
    @Override
    protected int getItemCount() {
        int itemCount = super.getItemCount();
        if (forceNotEmpty && itemCount == 0) {
            itemCount = 1;
        }
        return itemCount;
    }

}