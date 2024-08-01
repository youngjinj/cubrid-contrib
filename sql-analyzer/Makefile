CFLAGS += -fPIC -I"$(JAVA_HOME)/include" -I"$(JAVA_HOME)/include/win32" -I"$(CUBRID)/include" -Isrc/main/include
LDFLAGS += -shared

SQLValidator.class :
	javac src/main/jni/org/cubrid/validator/SQLValidator.java

sqlvalidator.h : SQLValidator.class
	mkdir -p src/main/include/
	javah -d src/main/include/ -cp target/classes/ org.cubrid.validator.SQLValidator

# $@ matches the target, $< matches the first dependancy
build/sqlvalidator.o : src/main/c/sqlvalidator.c sqlvalidator.h
	mkdir -p build/
	gcc -c $(CFLAGS) -o $@ $<

# $@ matches the target, $< matches the first dependancy
build/sqlvalidator.dll : build/sqlvalidator.o
	gcc $(LDFLAGS) -o $@ $<
	
all : clean build/sqlvalidator.dll

clean :
	rm -rf build
	rm -rf src/main/include