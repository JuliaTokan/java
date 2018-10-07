package url;

public class URLAddress {
    private String url;
    private String[] parameters;

    public URLAddress(String url) {
        this.url = url;

        try {
            setParameters();
        } catch (WrongParametersException e) {
            System.out.println(e.getMessage());
        }
    }


    public String[] findParameters() {
        try {
            int beginIndex = beginIndex();
            int endIndex = endIndex();
            String parameter = url.substring(beginIndex + 1, endIndex);
            return parameter.split("&");
        } catch (WrongParametersException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public int beginIndex() throws WrongParametersException {
        int beginIndex = url.indexOf('?');
        if (beginIndex == -1)
            throw new WrongParametersException("no parameters");
        return beginIndex;
    }

    public int endIndex() {
        int endIndex = url.indexOf('#');
        if (endIndex == -1)
            endIndex = url.length();
        return endIndex;
    }

    public void setParameters() throws WrongParametersException {
        String[] parameter = findParameters();
        if (parameter != null)
            for (String index : parameter) {
                int numEquals = index.length() - index.replace("=", "").length();
                if (numEquals != 1) {
                    throw new WrongParametersException("wrong parameters");
                }
            }
        parameters = parameter;
    }

    public void print() {
        if (parameters != null)
            for (String index : parameters) {
                System.out.println(index);
            }
    }


}
