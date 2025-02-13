    package com.balakhontsev.ecommerce.dao;

    import com.balakhontsev.ecommerce.entity.Role;
    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;

    @Repository
    public interface RoleDao extends JpaRepository<Role, String> {
    }
