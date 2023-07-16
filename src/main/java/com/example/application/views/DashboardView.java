package com.example.application.views;

import com.example.application.data.service.CrmService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.ChartType;
import com.vaadin.flow.component.charts.model.DataSeries;
import com.vaadin.flow.component.charts.model.DataSeriesItem;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility;
import jakarta.annotation.security.PermitAll;

/**
 * The dashboard view displaying summary information and charts for the CRM application.
 * This view includes a pie chart showing the number of employees in each company,
 * and a span displaying the total number of contacts in the CRM system.
 */
@PermitAll
@PageTitle("Dashboard | Vaadin CRM")
@Route(value = "dashboard", layout = MainLayout.class)
public class DashboardView extends VerticalLayout {

    private final CrmService service;

    /**
     * Constructs a new DashboardView with the provided CrmService.
     *
     * @param service The CrmService used to retrieve data for the dashboard.
     */
    public DashboardView(CrmService service) {
        this.service = service;
        addClassName("dashboard-view");
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        add(
                getContactStatus(),
                getCompaniesChart()
        );
    }

    /**
     * Creates and returns a component displaying the total number of contacts in the CRM system.
     * The contact count is retrieved from the CrmService and displayed as a Span.
     *
     * @return A Span component displaying the total number of contacts.
     */
    private Component getContactStatus() {
        var stats = new Span(service.countContacts() + " contact");
        stats.addClassNames(
                LumoUtility.FontSize.XLARGE,
                LumoUtility.Margin.Top.MEDIUM
        );
        return stats;
    }

    /**
     * Creates and returns a chart component displaying the number of employees in each company.
     * The data is retrieved from the CrmService and displayed as a pie chart using Vaadin Charts.
     *
     * @return A Chart component displaying the number of employees in each company.
     */
    private Component getCompaniesChart() {
        var chart = new Chart(ChartType.PIE);
        var dataSeries = new DataSeries();

        service.findAllCompanies()
                .forEach(company -> dataSeries.add(new DataSeriesItem(company.getName(),company.getEmployeeCount())));
        chart.getConfiguration().setSeries(dataSeries);

        return chart;
    }

}
