/*
 * @category CarPooling.
 * @copyright Copyright (C) 2017 Contus. All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0.1
 */

package com.contus.carpooling.server;

import com.squareup.otto.Bus;

/**
 * This is the Helper class that is used to communicate between activity and fragments.
 *
 * @author Contus Team <developers@contus.in>
 * @version 1.0
 */
public final class BusProvider {

    /**
     * Check whether the bus is register or not
     */
    private static boolean isRegistered;

    /**
     * Communicate between activity and fragments
     */
    private static Bus bus = new Bus();

    /**
     * Default constructor
     */
    private BusProvider() {
    }

    /**
     * Returns the instance of the bus.
     *
     * @return new instance
     */
    public static Bus getInstance() {
        if (bus == null) {
            bus = new Bus();
        }
        return bus;
    }

    /**
     * Sets the boolean value if the bus is registered or not
     *
     * @param registered - The registered bus instance
     */
    public static void setIsRegistered(final boolean registered) {
        isRegistered = registered;
    }

    /**
     * Get the status of the bus whether it is registered or not
     *
     * @return isRegistered boolean value to check whether the bus is registered or not
     */
    public static boolean isRegistered() {
        return isRegistered;
    }
}
