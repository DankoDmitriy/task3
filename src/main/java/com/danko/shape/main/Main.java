package com.danko.shape.main;

import com.danko.shape.comparator.ConeIdComparator;
import com.danko.shape.comparator.ConeVolumeComparator;
import com.danko.shape.entity.Cone;
import com.danko.shape.entity.ConeParameter;
import com.danko.shape.entity.Warehouse;
import com.danko.shape.factory.ConeFactory;
import com.danko.shape.observer.ConeObserver;
import com.danko.shape.observer.impl.ConeObserverImpl;
import com.danko.shape.parser.ConeParser;
import com.danko.shape.reader.DataReader;
import com.danko.shape.repository.ConeRepository;
import com.danko.shape.repository.ConeSpecification;
import com.danko.shape.repository.impl.ConeIdSpecification;
import com.danko.shape.service.ConeCalculateService;
import com.danko.shape.service.impl.ConeCalculateServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        String filepath = "test_data\\data.txt";

        DataReader dataReader = new DataReader();
        ConeParser coneParser = new ConeParser();
        ConeRepository repository = ConeRepository.getInstance();
        Warehouse warehouse = Warehouse.getInstance();
        ConeObserver observer = new ConeObserverImpl();
        ConeCalculateService coneCalculateService = new ConeCalculateServiceImpl();

        List<String> lines = dataReader.reader(filepath);
        List<double[]> conesParameters = coneParser.parseStringToDouble(lines);
        List<Cone> cones = ConeFactory.createListOfCones(conesParameters);

        for (Cone cone : cones) {
            double volume = coneCalculateService.calculateVolume(cone);
            double lateralSurfaceArea = coneCalculateService.calculateLateralSurfaceArea(cone);
            double area = coneCalculateService.calculateArea(cone);
            warehouse.put(cone.getConeId(), new ConeParameter(volume, area, lateralSurfaceArea));
        }
        repository.addAll(cones);

        for (int i = 0; i < repository.size(); i++) {
            repository.get(i).attach(observer);
        }

        for (int i = 0; i < repository.size(); i++) {
            repository.get(i).setHeight(16 + (i + 1));
        }

        for (int i = 1; i <= repository.size(); i++) {
            System.out.println("Id:" + i + " " + warehouse.get(i).toString());
        }

        ConeSpecification specification = new ConeIdSpecification(2);
        List<Cone> resultOfSelect = repository.query(specification);
        resultOfSelect.forEach(cone -> System.out.println(cone));
        repository.sort(new ConeVolumeComparator().thenComparing(new ConeIdComparator()));
        repository.getAll().forEach(cone -> System.out.println(cone));
    }
}
