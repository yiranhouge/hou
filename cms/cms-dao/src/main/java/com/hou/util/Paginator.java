package com.hou.util;

/**
 * @author : houlk
 * @description : 分页实体类
 * @date : 2017/12/12
 */
public class Paginator {
	private long total = 0l; //总记录数
	private int page = 1; //当前页数
	private long totalPage = 1; //总页数
	private int rows = 10; //每页记录数
	private int step = 5; //最多显示分页页码数
	private String param = "page"; //分页参数名称，用于支持一个页面多个分页功能
	private String url = ""; //项目路径
	private String query = ""; //当前页所有参数
	
	public long getTotal() {
		return total;
	}
	
	public void setTotal(long total) {
		this.total = total;
		initTotalPage();
	}
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	public long getTotalPage() {
		return totalPage;
	}
	
	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}
	
	public int getRows() {
		return rows;
	}
	
	public void setRows(int rows) {
		//设置最大记录数，限制单页记录过多
		rows = rows > 10000 ? 10000 : rows;
		this.rows = rows;
		initTotalPage();
	}
	
	public int getStep() {
		return step;
	}
	
	public void setStep(int step) {
		this.step = step;
	}
	
	public String getParam() {
		return param;
	}
	
	public void setParam(String param) {
		this.param = param;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getQuery() {
		return query;
	}
	
	public void setQuery(String query) {
		this.query = query;
	}
	
	/**
	 * 初始化分页信息
	 */
	public void initTotalPage() {
		totalPage = (total % rows) == 0 ? (total / rows) : ((total / rows) + 1);
		if (page > totalPage) {
			page = (int) totalPage;
		}
		if (page < 1) {
			page = 1;
		}
	}
	
	public String getHtml() {
		//根据request获取当前的url，包括参数，如果有已存在名称的param name 的参数，剔除掉，后面追加新的参数
		if (query != null){
			String params = "";
			String[] querys = query.split("&");
			for (int i = 0; i < querys.length; i++) {
				if (querys[i].startsWith(param)){
					continue;
				}
				if (params.equals("")){
					params += querys[i];
				} else {
					params += "&"+querys[i];
				}
			}
			if (!params.equals("")){
				url += "?"+params;
			}
			//结果html
			String pages = "";
			int pageCount = (int) Math.ceil((double)total / rows);//求总页数
			//if ()
		}
		return null;
	}
}

