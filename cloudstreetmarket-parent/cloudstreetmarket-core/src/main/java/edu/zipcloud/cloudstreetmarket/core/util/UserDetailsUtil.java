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
package edu.zipcloud.cloudstreetmarket.core.util;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import edu.zipcloud.cloudstreetmarket.core.enums.Role;

public class UserDetailsUtil {
	
	public static boolean hasRole(UserDetails userDetails, Role role){
		return hasRole(userDetails.getAuthorities(), role);
	}
	
	public static boolean hasRole(Collection<? extends GrantedAuthority> authorities, Role role){
		return authorities.stream()
			.filter(a -> {
				return a.getAuthority().equals(role.toString());
			})
			.findFirst()
			.isPresent();
	}
}
