package com.barbeariapremium.app.ui.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bq\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b\u00a2\u0006\u0002\u0010\u0011J\t\u0010\u001e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0007H\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u00c6\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bH\u00c6\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bH\u00c6\u0003Ju\u0010\'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bH\u00c6\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010+\u001a\u00020\u0007H\u00d6\u0001J\t\u0010,\u001a\u00020-H\u00d6\u0001R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015\u00a8\u0006."}, d2 = {"Lcom/barbeariapremium/app/ui/viewmodel/DashboardStats;", "", "dailyRevenue", "", "weeklyRevenue", "monthlyRevenue", "todayAppointments", "", "activeCustomers", "averageTicket", "topBarbers", "", "Lcom/barbeariapremium/app/ui/viewmodel/BarberRanking;", "topServices", "Lcom/barbeariapremium/app/ui/viewmodel/ServiceStats;", "topCustomers", "Lcom/barbeariapremium/app/ui/viewmodel/CustomerRanking;", "(DDDIIDLjava/util/List;Ljava/util/List;Ljava/util/List;)V", "getActiveCustomers", "()I", "getAverageTicket", "()D", "getDailyRevenue", "getMonthlyRevenue", "getTodayAppointments", "getTopBarbers", "()Ljava/util/List;", "getTopCustomers", "getTopServices", "getWeeklyRevenue", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "", "app_debug"})
public final class DashboardStats {
    private final double dailyRevenue = 0.0;
    private final double weeklyRevenue = 0.0;
    private final double monthlyRevenue = 0.0;
    private final int todayAppointments = 0;
    private final int activeCustomers = 0;
    private final double averageTicket = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.barbeariapremium.app.ui.viewmodel.BarberRanking> topBarbers = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.barbeariapremium.app.ui.viewmodel.ServiceStats> topServices = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.barbeariapremium.app.ui.viewmodel.CustomerRanking> topCustomers = null;
    
    public DashboardStats(double dailyRevenue, double weeklyRevenue, double monthlyRevenue, int todayAppointments, int activeCustomers, double averageTicket, @org.jetbrains.annotations.NotNull()
    java.util.List<com.barbeariapremium.app.ui.viewmodel.BarberRanking> topBarbers, @org.jetbrains.annotations.NotNull()
    java.util.List<com.barbeariapremium.app.ui.viewmodel.ServiceStats> topServices, @org.jetbrains.annotations.NotNull()
    java.util.List<com.barbeariapremium.app.ui.viewmodel.CustomerRanking> topCustomers) {
        super();
    }
    
    public final double getDailyRevenue() {
        return 0.0;
    }
    
    public final double getWeeklyRevenue() {
        return 0.0;
    }
    
    public final double getMonthlyRevenue() {
        return 0.0;
    }
    
    public final int getTodayAppointments() {
        return 0;
    }
    
    public final int getActiveCustomers() {
        return 0;
    }
    
    public final double getAverageTicket() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.barbeariapremium.app.ui.viewmodel.BarberRanking> getTopBarbers() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.barbeariapremium.app.ui.viewmodel.ServiceStats> getTopServices() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.barbeariapremium.app.ui.viewmodel.CustomerRanking> getTopCustomers() {
        return null;
    }
    
    public DashboardStats() {
        super();
    }
    
    public final double component1() {
        return 0.0;
    }
    
    public final double component2() {
        return 0.0;
    }
    
    public final double component3() {
        return 0.0;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int component5() {
        return 0;
    }
    
    public final double component6() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.barbeariapremium.app.ui.viewmodel.BarberRanking> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.barbeariapremium.app.ui.viewmodel.ServiceStats> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.barbeariapremium.app.ui.viewmodel.CustomerRanking> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.barbeariapremium.app.ui.viewmodel.DashboardStats copy(double dailyRevenue, double weeklyRevenue, double monthlyRevenue, int todayAppointments, int activeCustomers, double averageTicket, @org.jetbrains.annotations.NotNull()
    java.util.List<com.barbeariapremium.app.ui.viewmodel.BarberRanking> topBarbers, @org.jetbrains.annotations.NotNull()
    java.util.List<com.barbeariapremium.app.ui.viewmodel.ServiceStats> topServices, @org.jetbrains.annotations.NotNull()
    java.util.List<com.barbeariapremium.app.ui.viewmodel.CustomerRanking> topCustomers) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}