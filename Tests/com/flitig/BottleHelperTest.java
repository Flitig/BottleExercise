package com.flitig;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Flitig on 2016-06-13.
 */
public class BottleHelperTest {
    @Test
    public void pourInto() throws Exception {
        IBottle bottle1 = new Bottle(5, 2);
        IBottle bottle2 = new Bottle(4, 3);

        List<IBottle> res = BottleHelper.SINGLETON.PourInto(bottle1, bottle2);

        assertEquals(1, res.get(0).getCurrentVolume());
        assertEquals(4, res.get(1).getCurrentVolume());

    }
}