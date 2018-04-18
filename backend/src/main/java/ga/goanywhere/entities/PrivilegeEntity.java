package ga.goanywhere.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "privilege", schema = "goanywhere", catalog = "")
public class PrivilegeEntity {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

}
