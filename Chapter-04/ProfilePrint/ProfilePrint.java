class ProfilePrint {
    byte age;
    String name;
    boolean isMarried;

    public void setAge(byte age) {
        this.age = age;
    }

    public byte getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMarried(boolean flag) {
        isMarried = flag;
    }

    public boolean isMarried() {
        return isMarried;
    }

    public static void main(String[] args) {
        ProfilePrint profilePrint = new ProfilePrint();

        profilePrint.setAge((byte)27);
        profilePrint.setName("김선규");
        profilePrint.setMarried(false);

        System.out.println(profilePrint.getAge());
        System.out.println(profilePrint.getName());
        System.out.println(profilePrint.isMarried());
    }
}