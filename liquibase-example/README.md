The following command should be ran to execute this POM

mvn liquibase:update -Dliquibase.changeLogFile=src/main/resources/liquibase/parentLiquibaseChangeLog.xml

mvn liquibase:update -Dliquibase.changeLogFile=src/main/resources/liquibase/parentLiquibaseChangeLog.xml liquibase:generateChangeLog liquibase:dbDoc




