package com.training.ykb.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartWithCheckImpl implements ConstraintValidator<StartWithCheck, String> {

    private StartWithCheck swc;

    @Override
    public void initialize(final StartWithCheck swc) {
        this.swc = swc;
    }

    @Override
    public boolean isValid(final String valueParam,
                           final ConstraintValidatorContext contextParam) {
        return valueParam.startsWith(this.swc.start());
    }

}
