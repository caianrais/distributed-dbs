package server;
/*
   Caian R. Ertl     (@caianrais)       - 20733152
   Diogo Casagrande  (@DiogoCasagrande) - 20718678
   Julia G. C. Chiba (@JuliaChiba)      - 20511823
 */

class Config
{
    protected static final int PORT        = Integer.parseInt(System.getenv("H2_TCP_PORT"));
    protected static final String BASE     = System.getenv("H2_DBNAME");
    protected static final String HOSTNAME = System.getenv("H2_HOSTNAME");
    protected static final String USERNAME = System.getenv("H2_USERNAME");
    protected static final String PASSWORD = System.getenv("H2_PASSWORD");
}
