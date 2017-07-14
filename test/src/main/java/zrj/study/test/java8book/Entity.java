package zrj.study.test.java8book;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/7/5
 */
public class Entity {
    private String id;
    private String name;

    public Entity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("someone call me");
        return super.equals(obj);
    }
}
