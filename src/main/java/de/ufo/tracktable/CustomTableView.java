package de.ufo.tracktable;

import javafx.scene.control.Skin;
import javafx.scene.control.TableView;

public class CustomTableView extends TableView<UFO> {
    @Override
    protected Skin<?> createDefaultSkin() {
        return new CustomTableSkin<>(this);
    }
}
