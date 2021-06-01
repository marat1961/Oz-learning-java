class Book {

    private String title;
    private int yearOfPublishing;
    private String[] authors;

    public Book(String title, int yearOfPublishing, String[] authors) {
        this.title = title;
        this.yearOfPublishing = yearOfPublishing;
        this.authors = authors.clone();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (String s : authors) {
            if (sb.length() != 0) {
                sb.append(',');
            }
            sb.append(s);
        }
        return String.format("title=%s,yearOfPublishing=%d,authors=[%s]",
                title, yearOfPublishing, sb.toString());
    }

}