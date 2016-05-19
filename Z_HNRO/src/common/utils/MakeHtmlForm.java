package common.utils;

import java.util.ArrayList;
import java.util.HashMap;

import models.TableHeaderModel;

public class MakeHtmlForm {
	public static void main(String[] args) {
		test();
	}
	
	static void test() {
		ArrayList<HashMap<String, String>> rawData = new ArrayList<>();
		HashMap<String, String> data = new HashMap<>();
		data.put("shortcut", "");
		data.put("companyNm", "HVCCK");
		data.put("lineNm", "CDND");
		data.put("eqpNm", "CLine");
		data.put("itemNm", "F760");
		data.put("pmfNm", "He.Leak test");
		data.put("mkDate", "2015-02-21");
		data.put("mkTime", "08:23");
		data.put("patternNm", "R");
		data.put("stdLower", "");
		data.put("ucl", "0");
		data.put("meaAvg", "0.003582134");
		data.put("meaValue1", "0.0003124");
		data.put("meaValue2", "0.0003124");
		data.put("meaValue3", "0.0003124");
		data.put("meaValue4", "0.0003124");
		data.put("meaValue5", "0.0003124");
		data.put("plantNm", "대전공장");
		data.put("processNm", "6alnc");
		data.put("carTypeNm", "dm(d)");
		data.put("pmfSubNm", "he.leck");
		data.put("lotNo", "20150221");
		data.put("actionTypeNm", "send");
		data.put("stdUpper", "0.3324324");
		data.put("ucl", "0.0030123");
		data.put("meaPalette1", "34");
		data.put("meaPalette2", "34");
		data.put("meaPalette3", "34");
		data.put("meaPalette4", "34");
		data.put("meaPalette5", "34");
		rawData.add(data);
		
		ArrayList<TableHeaderModel> headerSet = new ArrayList<>();
		headerSet.add(new TableHeaderModel("no", "2"));
		headerSet.add(new TableHeaderModel("shortcut", "2"));
		headerSet.add(new TableHeaderModel("company"));
		headerSet.add(new TableHeaderModel("line"));
		headerSet.add(new TableHeaderModel("eqp"));
		headerSet.add(new TableHeaderModel("item", "2"));
		headerSet.add(new TableHeaderModel("pmf"));
		headerSet.add(new TableHeaderModel("mkdatetime"));
		headerSet.add(new TableHeaderModel("abnormalPattern"));
		headerSet.add(new TableHeaderModel("lowerStd"));
		headerSet.add(new TableHeaderModel("lowerMgt"));
		headerSet.add(new TableHeaderModel("measureAverage", "2"));
		headerSet.add(new TableHeaderModel("one", "2", "1"));
		headerSet.add(new TableHeaderModel("two", "2", "1"));
		headerSet.add(new TableHeaderModel("three", "2", "1"));
		headerSet.add(new TableHeaderModel("four", "2", "1"));
		headerSet.add(new TableHeaderModel("five", "2", "1"));
		headerSet.add(new TableHeaderModel(true));
		headerSet.add(new TableHeaderModel("plant"));
		headerSet.add(new TableHeaderModel("process"));
		headerSet.add(new TableHeaderModel("carType"));
		headerSet.add(new TableHeaderModel("pmfSub"));
		headerSet.add(new TableHeaderModel("lotNo"));
		headerSet.add(new TableHeaderModel("measureRegist"));
		headerSet.add(new TableHeaderModel("upperStd"));
		headerSet.add(new TableHeaderModel("upperMgt"));
		
		ArrayList<ArrayList<String>> body = new ArrayList<>();
		ArrayList<String> row;
		int i, size;
		HashMap<String, String> model;
		for (i = 0, size = rawData.size(); i < size; i++) {
			model = rawData.get(i);
			row = new ArrayList<>();
			
			row.add((i + 1) + "");
			row.add(model.get("shortcut"));
			row.add(model.get("companyNm"));
			row.add(model.get("lineNm"));
			row.add(model.get("eqpNm"));
			row.add(model.get("itemNm"));
			row.add(model.get("pmfNm"));
			row.add(model.get("mkDate") + model.get("mkTime"));
			row.add(model.get("patternNm"));
			row.add(model.get("stdLower"));
			row.add(model.get("ucl"));
			row.add(model.get("meaAvg"));
			row.add(model.get("meaValue1"));
			row.add(model.get("meaValue2"));
			row.add(model.get("meaValue3"));
			row.add(model.get("meaValue4"));
			row.add(model.get("meaValue5"));
			row.add(model.get(""));
			row.add(model.get("plantNm"));
			row.add(model.get("processNm"));
			row.add(model.get("carTypeNm"));
			row.add(model.get("pmfSubNm"));
			row.add(model.get("lotNo"));
			row.add(model.get("actionTypeNm"));
			row.add(model.get("stdUpper"));
			row.add(model.get("ucl"));
			row.add(model.get("meaPalette1"));
			row.add(model.get("meaPalette2"));
			row.add(model.get("meaPalette3"));
			row.add(model.get("meaPalette4"));
			row.add(model.get("meaPalette5"));
			
			body.add(row);
		}
		
		String result = makeHtml("", makeHtmlTable(headerSet, body));
		System.out.println(result);
	}
	
	public static String makeHtml(String style, String body) {
		StringBuffer html = new StringBuffer("<html>");
		
		html.append("<head>");
		html.append(style);
		html.append("</head>");
		
		html.append("<body>");
		html.append(body);
		html.append("</body>");
		
		html.append("</html>");
		return html.toString();
	}
	
	public static String makeHtmlTable(ArrayList<TableHeaderModel> headerSet, ArrayList<ArrayList<String>> body) {
		StringBuffer html = new StringBuffer();
		int i, j, size;
		int headerSize = headerSet.size();
		int bodySize = body.size();
		TableHeaderModel thm;
		ArrayList<String> bodyItem;
		
		html.append("<table style=\"text-align:center;\">>");
		
		html.append("<thead>");
		html.append("<tr>");
		for (i = 0; i < headerSize; i++) {
			thm = headerSet.get(i);
			
			if (thm.isNewRow()) {
				html.append("</tr><tr>");
			} else {
				html.append("<th colspan=\"");
				html.append(thm.getColSpan());
				html.append("\" rowspan=\"");
				html.append(thm.getRowSpan());
				html.append("\">");
				html.append(thm.getHeader());
				html.append("</th>");
			}
		}
		html.append("</tr>");
		html.append("</thead>");
		
		html.append("<tbody>");
		html.append("<tr>");
		for (i = 0; i < bodySize; i++) {
			bodyItem = body.get(i);
			for (j = 0, size = bodyItem.size(); j < size; j++) {
				if (j < headerSize) {
					thm = headerSet.get(j);
					
					if (thm.isNewRow()) {
						html.append("</tr><tr>");
					} else {
						html.append("<td colspan=\"");
						html.append(thm.getTbodyColSpan());
						html.append("\" rowspan=\"");
						html.append(thm.getTbodyRowSpan());
						html.append("\">");
						html.append(bodyItem.get(j));
						html.append("</td>");
					}
				} else {
					html.append("<td>");
					html.append(bodyItem.get(j));
					html.append("</td>");
				}
			}
		}
		html.append("</tr>");
		html.append("</tbody>");
		
		html.append("</table>");
		
		return html.toString();
	}
}
