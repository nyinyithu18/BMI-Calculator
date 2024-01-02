package com.bmicalculatorproject.bmicalculator.service;

import com.bmicalculatorproject.bmicalculator.model.BmiModel;

public interface BmiService {

	public BmiModel resultBmi(String weight, String height, String inches);
}
