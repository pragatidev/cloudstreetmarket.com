/***
 *  Cloudstreetmarket.com is a Spring MVC showcase application developed 
 *  with the book Spring MVC Cookbook [PACKT] (2015). 
 * 	Copyright (C) 2015  Alex Bretet
 *  
 *  This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * 
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 * 
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 **/
package edu.zipcloud.cloudstreetmarket.core.daos;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;

import edu.zipcloud.cloudstreetmarket.core.entities.Exchange;
import edu.zipcloud.cloudstreetmarket.core.entities.Index;
import edu.zipcloud.cloudstreetmarket.core.entities.StockProduct;

public interface StockProductRepository extends JpaRepository<StockProduct, String>, JpaSpecificationExecutor<StockProduct> {
	Page<StockProduct> findByNameStartingWith(String param, Pageable pageable);
	Page<StockProduct> findByNameStartingWith(String param, Specification<StockProduct> spec, Pageable pageable);
	
	Page<StockProduct> findByExchange(Exchange exchange, Pageable pageable);
	@EntityGraph(value = "StockProduct.detail", type = EntityGraphType.LOAD)
	Page<StockProduct> findByIndices(Index index, Pageable pageable);
	List<StockProduct> findByIdIn(List<String> asList);
}