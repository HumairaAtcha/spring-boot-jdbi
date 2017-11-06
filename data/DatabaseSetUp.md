## Install MySQL on a Mac

Ensure you have [Homebrew](https://brew.sh/) installed.

```bash
brew install mysql
mysql.server start
mysqladmin -u root password
```

Enter a root password of your choosing for the MySQL server.

If problems getting access, start up with no authentication:
```bash
mysqld_safe --skip-grant-tables &
```

To initialize the database:

```bash
mysql -uroot -p < create_tables.sql
mysql -uroot -p -D zoo < insert_animals.sql
```
To start the MySql command line client:
```bash
# With authentication
mysqladmin -u root password

# Without authentication
mysql -u root
```
Enter `quit` or `^D` to quit.

```mysql
use zoo;
select * from animals;
```
