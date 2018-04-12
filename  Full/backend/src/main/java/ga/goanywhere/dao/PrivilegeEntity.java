package ga.goanywhere.dao;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "privilege", schema = "goanywhere", catalog = "")
public class PrivilegeEntity {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrivilegeEntity that = (PrivilegeEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, type);
    }
}
