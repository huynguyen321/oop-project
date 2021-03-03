package Framework;

import java.util.ArrayList;

public class Account {

    private String username = "Demo";
    private String password = "12345678";
    private String role = "User";
    private ArrayList<Integer> bookmark;
    private ArrayList<Integer> project;

    public Account() {
        if (this.role.contentEquals("Translator")) {
            this.project = new ArrayList<>();
        }
    }

    public Account(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
        this.setRole("User");
    }

    public Account(String username, String password, String role, ArrayList<Integer> bookmark) {
        this.setUsername(username);
        this.setPassword(password);
        this.setRole(role);
        this.setBookmark(bookmark);
        if (this.role.contentEquals("Translator")) {
            this.project = new ArrayList<>();
        }
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        if (username.length() > 1) {
            this.username = username;
        }
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        if (password.length() >= 6) {
            this.password = password;
        }
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        if (role.contentEquals("Administrator") || role.contentEquals("User") || role.contentEquals("Translator")) {
            this.role = role;
        }
    }

    public ArrayList<Integer> getBookmark() {
        return this.bookmark;
    }

    public void setBookmark(ArrayList<Integer> bookmark) {
        this.bookmark = bookmark;
    }

    public ArrayList<Integer> getProject() {
        return this.project;
    }
// chuc nang danh rieng cho trans

    public void addProject(int project) {
        if (this.role.contentEquals("Translator")) {
            this.project.add(project);
        }
    }

    public void removeProject(int project) {//co them admin de admin xoa nhung truyen khong phu hop
        if ((this.role.contentEquals("Translator") || this.role.contentEquals("Administrator")) && this.project.size() > 0) {
            this.project.remove(project);
        }
    }

    @Override
    public String toString() {
        return "Acount name: " + this.getUsername() + "\nRole: " + this.getRole();
    }

}
