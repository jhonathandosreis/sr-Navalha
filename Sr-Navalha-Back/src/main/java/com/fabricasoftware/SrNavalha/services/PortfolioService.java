package com.fabricasoftware.SrNavalha.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fabricasoftware.SrNavalha.models.Portfolio;
import com.fabricasoftware.SrNavalha.repositories.PortfolioRepository;

@Service
public class PortfolioService {
	
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
