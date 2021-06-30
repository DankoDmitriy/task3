package com.danko.shape.factory;

import com.danko.shape.entity.Cone;
import com.danko.shape.entity.Point;
import com.danko.shape.exception.ConeException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ConeFactoryTest {
    @DataProvider(name = "valid_data")
    public Object[][] createConeData() throws ConeException {
        return new Object[][]{
                {new double[]{1.0, 1.0, 0.0, 6.0, 4.0}, new Cone(new Point(1.0, 1.0, 0.0), 6.0, 4.0)},
                {new double[]{2.0, 3.0, 4.0, 7.0, 2.0}, new Cone(new Point(2.0, 3.0, 4.0), 7.0, 2.0)}
        };
    }

    @DataProvider(name = "valid_data_list")
    public Object[][] createConeDataList() throws ConeException {
        return new Object[][]{
                {Arrays.asList(new double[]{1.0, 1.0, 0.0, 6.0, 4.0}), Arrays.asList(new Cone(new Point(1.0, 1.0, 0.0), 6.0, 4.0))},
                {Arrays.asList(new double[]{2.0, 3.0, 4.0, 7.0, 2.0}), Arrays.asList(new Cone(new Point(2.0, 3.0, 4.0), 7.0, 2.0))}
        };
    }

    @Test(dataProvider = "valid_data")
    public void createCone(double[] parameters, Cone expected) throws ConeException {
        Cone cone = ConeFactory.createCone(parameters);
        assertEquals(cone, expected);
    }

    @Test(dataProvider = "valid_data_list")
    public void createConeList(List<double[]> doubles, List<Cone> expectedCones) throws ConeException {
        List<Cone> cones = ConeFactory.createListOfCones(doubles);
        assertEquals(cones, expectedCones);
    }
}
