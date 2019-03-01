/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartstart.service;

import java.util.List;

/**
 *
 * @author USER
 */
public interface IService<T> {
    public boolean add(T t);	
	public boolean delete(T t);	
	public boolean update(T t);
	public T getById(int id);
	public List<T> getAll();
}
