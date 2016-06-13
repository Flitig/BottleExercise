package com.flitig;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Flitig on 2016-06-13.
 */
public enum BottleHelper {
    SINGLETON;

    public List<IBottle> PourInto(IBottle from, IBottle into) {
        int fromBefore = from.getCurrentVolume();
        int intoBefore = into.getCurrentVolume();

        if (fromBefore <= into.getFreeCapacity()) {
            into.setCurrentVolume(intoBefore + fromBefore);
            from.setCurrentVolume(0);
        } else if (fromBefore > into.getFreeCapacity()) {
            from.setCurrentVolume(fromBefore - into.getFreeCapacity());
            into.setCurrentVolume(into.getMaxCapacity());
        }
        List<IBottle> bottlesList = new ArrayList<>();
        bottlesList.add(from);
        bottlesList.add(into);
        return bottlesList;
    }

    public IBottle EmptyBottle(IBottle b) {
        b.setCurrentVolume(0);
        return b;
    }

    public IBottle FillBottle(IBottle b) {
        b.setCurrentVolume(b.getMaxCapacity());
        return b;
    }
}
