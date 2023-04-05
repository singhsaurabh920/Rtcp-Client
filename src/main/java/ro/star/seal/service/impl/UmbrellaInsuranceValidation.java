package ro.star.seal.service.impl;

import ro.star.seal.dto.SessionDataDto;
import ro.star.seal.service.IValidationPlugin;

import java.util.HashMap;

public class UmbrellaInsuranceValidation implements IValidationPlugin {

    static {
        ValidationPluginFactory.getInstance().registerPlugin(UmbrellaInsuranceValidation.class.getName(), UmbrellaInsuranceValidation.class);
    }

    @Override
    public boolean validate(SessionDataDto sessionDataDto, String metaDataName, String metaDataBusinessName, Object metaDataValue, HashMap<String, Object> metaDatas) throws Exception {
        return false;
    }
}
