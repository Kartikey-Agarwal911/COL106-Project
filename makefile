all: 
	@javac DSCoinPackage/*.java HelperClasses/*.java
	@java DSCoinPackage/DriverCode

clean:
	@rm *.class DSCoinPackage/*.class
	@rm *.class HelperClasses/*.class
