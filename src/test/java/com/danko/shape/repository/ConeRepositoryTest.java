package com.danko.shape.repository;

import com.danko.shape.comparator.ConeIdComparator;
import com.danko.shape.comparator.ConeVolumeComparator;
import com.danko.shape.entity.Cone;
import com.danko.shape.entity.Point;
import com.danko.shape.exception.ConeException;
import com.danko.shape.repository.impl.ConeIdSpecification;
import com.danko.shape.repository.impl.ConeMaxHeightSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ConeRepositoryTest {
    private ConeRepository repository;

    @BeforeClass
    public void createRepository() throws ConeException {
        repository = ConeRepository.getInstance();
        repository.add(new Cone(new Point(1.0, 1.0, 0.0), 1.0, 3.0));
        repository.add(new Cone(new Point(1.0, 2.0, 0.0), 2.0, 4.0));
        repository.add(new Cone(new Point(1.0, 1.0, 2.0), 3.0, 5.0));
    }

    @DataProvider(name = "query_data")
    public Object[][] createQueryData() throws ConeException {
        return new Object[][]{
                {new ConeIdSpecification(1), Arrays.asList(new Cone(new Point(1.0, 1.0, 0.0), 1.0, 3.0))},
                {new ConeMaxHeightSpecification(4), Arrays.asList(new Cone(new Point(1.0, 1.0, 0.0), 1.0, 3.0)
                        , new Cone(new Point(1.0, 2.0, 0.0), 2.0, 4.0))}
        };
    }

    @DataProvider(name = "sort_data")
    public Object[][] createSortData() throws ConeException {
        return new Object[][]{
                {new ConeIdComparator(), Arrays.asList(
                        new Cone(new Point(1.0, 1.0, 0.0), 1.0, 3.0),
                        new Cone(new Point(1.0, 2.0, 0.0), 2.0, 4.0),
                        new Cone(new Point(1.0, 1.0, 2.0), 3.0, 5.0))
                },
                {new ConeVolumeComparator(), Arrays.asList(
                        new Cone(new Point(1.0, 1.0, 0.0), 1.0, 3.0),
                        new Cone(new Point(1.0, 2.0, 0.0), 2.0, 4.0),
                        new Cone(new Point(1.0, 1.0, 2.0), 3.0, 5.0))
                }
        };
    }

    @Test(dataProvider = "query_data")
    public void queryTest(ConeSpecification specification, List<Cone> expectedConeList) throws ConeException {
        List<Cone> queryData = repository.query(specification);
        assertEquals(queryData, expectedConeList);
    }

    @Test(dataProvider = "sort_data")
    public void sortTest(Comparator comparator, List<Cone> expectedConeList) throws ConeException {
        repository.sort(comparator);
        List<Cone> sortData = repository.getAll();
        assertEquals(sortData, expectedConeList);
    }


}
