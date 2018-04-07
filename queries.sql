
1. #show titles of movies rented by a specific member 
select title from movies natural join rentals where m_id = ___;

2. #show the total number of sales by employees
select e_id, count(e_id) as sales from sales group by e_id;

3. #show all movies in stock
select title, qoh from movies where qoh > 0;

4. #show all members that a given employee has made sales to
select m_id from members natural join sales natural join employees where e_id = ___;

5. #search movies by genre
select * from movies where category = ___;

6. #sort movies by qoh
select * from movies order by qoh desc;

7. #show movies from a specific vendor
select * from movies where vendor_name = ___;

8. #show sale information for a given store
select e_id, sale_num, m_id, sale_date, v_id from employees natural join store natural join sales where store_num = ___;

9. #show rental information for a given store
select e_id, rental_num, m_id, v_id, date_out, date_in from employees natural join store natural join rentals where store_num = ___;

10. #show employees over a commission rate threshold
select * from employees where commission_rate > ___ order by commission_rate desc;