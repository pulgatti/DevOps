interface Report {
    public Object[][] getReportData(final String reportId);
    public String getFirstColumnData();
}

class SupportReport implements Report {
 
    @Override
    public Object[][] getReportData(String reportId) {
        return null;
    }
 
    @Override
    public String getFirstColumnData() {
        return "Support data";
    }
     
}

abstract class ColumDecorator implements Report 
{
    private Report decoratedReport;
     
    public ColumDecorator(Report report){
        this.decoratedReport = report;
    }
     
    public String getFirstColumnData() {
        return decoratedReport.getFirstColumnData(); 
    }
     
    @Override
    public Object[][] getReportData(String reportId) {
        return decoratedReport.getReportData(reportId);
    }
}

class SupportLinkDecorator extends ColumDecorator{
 
    public SupportLinkDecorator(Report report) {
        super(report);
    }
 
    public String getFirstColumnData() {
        return addMoreInfo (super.getFirstColumnData()) ;
    }
     
    private String addMoreInfo(String data){
        return data  + " - support link - ";
    }
}


class SupportPopupDecorator extends ColumDecorator{
 
    public SupportPopupDecorator(Report report) {
        super(report);
    }
 
    public String getFirstColumnData() {
        return addPopup (super.getFirstColumnData()) ;
    }
     
    private String addPopup(String data){
        return data  + " - support popup - ";
    }
}

public class Decorator {
    public static void main(String[] args) {
         
      SupportPopupDecorator supportPopupDecoratored = new SupportPopupDecorator(new SupportLinkDecorator(new SupportReport()));
       System.out.println(supportPopupDecoratored.getFirstColumnData());
    }
}
