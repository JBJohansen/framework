/*
 * Copyright 2000-2016 Vaadin Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.vaadin.navigator;

import java.io.Serializable;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Component;

/**
 * Interface for all views controlled by the navigator.
 *
 * Each view added to the navigator must implement this interface. Typically, a
 * view is a {@link Component}, if it is not then you should override
 * {@link #getViewComponent()} to define the component to show for the view.
 *
 * @author Vaadin Ltd
 * @since 7.0
 */
public interface View extends Serializable {

    /**
     * This view is navigated to.
     *
     * This method is always called before the view is shown on screen.
     * {@link ViewChangeEvent#getParameters() event.getParameters()} may contain
     * extra parameters relevant to the view.
     *
     * @param event
     *            ViewChangeEvent representing the view change that is
     *            occurring. {@link ViewChangeEvent#getNewView()
     *            event.getNewView()} returns <code>this</code>.
     *
     */
    public void enter(ViewChangeEvent event);

    /**
     * Gets the component to show when navigating to the view.
     *
     * By default casts this View to a {@link Component} if possible, otherwise
     * throws an IllegalStateException.
     *
     * @since 8.1
     * @return the component to show, by default the view instance itself
     */
    public default Component getViewComponent() {
        if (!(this instanceof Component)) {
            throw new IllegalStateException(
                    "View is not a Component. Override getViewComponent() to return the root view component");
        }
        return (Component) this;
    }
}
