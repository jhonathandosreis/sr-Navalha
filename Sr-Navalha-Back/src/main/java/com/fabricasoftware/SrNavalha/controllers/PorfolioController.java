package com.fabricasoftware.SrNavalha.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fabricasoftware.SrNavalha.models.Portfolio;
import com.fabricasoftware.SrNavalha.repositories.PortfolioRepository;

@RestController
@RequestMapping(value = "/portfolios")
public class PorfolioController {
	
	    @Autowired
	    private PortfolioRepository portfolioRepository;

	    public List<Portfolio> findAll() {
	        return portfolioRepository.findAll();
	    }

	    public Portfolio create(Portfolio portfolio) {
	        portfolio = portfolioRepository.save(portfolio);
	        return portfolio;
	    }

	    public Portfolio update(Portfolio portfolio) {
	        portfolio = portfolioRepository.save(portfolio);
	        return portfolio;
	    }

	    public void delete(Long id) {
	        portfolioRepository.deleteById(id);
	    }	

}
