package com.bmicalculatorproject.bmicalculator.service.serviceimpl;

import org.springframework.stereotype.Service;

import com.bmicalculatorproject.bmicalculator.model.BmiModel;
import com.bmicalculatorproject.bmicalculator.service.BmiService;

@Service
public class BmiServiceImpl implements BmiService {

	@Override
	public BmiModel resultBmi(String weight, String height, String inches) {
				
		double convertInches = (Double.parseDouble(height) * 12) + Double.parseDouble(inches) ;
		double resultBmi = (Double.parseDouble(weight) / (convertInches * convertInches)) * 703;
		
		BmiModel bmiModel = new BmiModel();
		bmiModel.setBmi(resultBmi);
		
		if (resultBmi <= 18.4) {
			bmiModel.setResultStatus("Underweight");
		}else if (resultBmi >= 18.5 && resultBmi <= 24.9) {
			bmiModel.setResultStatus("Normal");
		}else if (resultBmi >= 25.0 && resultBmi <= 39.9) {
			bmiModel.setResultStatus("Overweight");
		}else if (resultBmi >= 40.0) {
			bmiModel.setResultStatus("Obese");
		}
		
		return bmiModel;
	}
}
