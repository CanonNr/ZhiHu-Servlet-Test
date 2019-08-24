package cn.lksun.Domain;

public class ResultInfo {
    private boolean flag;
    private Object data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private String msg;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }



    public ResultInfo(boolean flag){
        this.flag = flag;
    }

    public ResultInfo(){
        this.flag = true;
    }


}
