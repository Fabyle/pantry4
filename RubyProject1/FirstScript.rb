# require relative à l'emplacement du fichier courant
require_relative 'dog.rb'

# simple operation to test
puts 3+3
puts 3+3+4

#-------------------------------------------------------
# MAIN DE TEST is playing with DOGs
#-------------------------------------------------------
myDog = Dog.new("Rex","Coton Tulear")
myDog.myName="Rex2"
myDog.myRace="Berger"
puts myDog
puts "This is a dog : #{myDog.inspect}"


#-------------------------------------------------------
# Manipulation de chaines
#-------------------------------------------------------
#print('Enter your name : ')
#name = gets()
#puts("Hello #{name}")

# autre délimiteur de chaine %Q
puts %Q[this is a string]

puts "toto " << "truc"
puts "toto " + "truc"
puts "toto " "truc"

#-------------------------------------------------------
# Manipulation des arrays
#-------------------------------------------------------
arr = ['one', 'two', 'three', 'four']
puts arr[1]

def hello
  return "hello world"
end

x=[1+2, hello, `dir`]# back quote => dir system
puts x[1]
puts x[2]

#-------------------------------------------------------
# boucle for
#-------------------------------------------------------

multiarr = [['one','two', "three", "four"],[1,2,3,4]]

for i in multiarr
  puts (i.inspect)
end

#-------------------------------------------------------
# indexing into Arrays
# on peut indexer depuis la fin d'un Array avec -
#-------------------------------------------------------
arr = ['H','e','l','l','o','w','o','r','l','d']
print(arr[0,5])
print(arr[-5,5])
print(arr[0..4]) 
print(arr[-5..-1])
puts "---"
  
#-------------------------------------------------------
# copy d'un array
#------------------------------------------------------
arr1=arr.clone

#-------------------------------------------------------
# array equality
#------------------------------------------------------
puts arr <=> arr1

#-------------------------------------------------------
# sort array
#------------------------------------------------------
arrbis = [1,5,4,3,2,'g','d','c']

arrbisTri = arrbis.sort{
  |a,b|
  a.to_s<=>b.to_s
}
print arrbisTri
puts

#-------------------------------------------------------
# comparable
#------------------------------------------------------
class MyArray < Array
  include Comparable
  
  def <=> ( anotherArray)
    self.length <=> anotherArray.length
  end
end

myArr1 = MyArray.new([0,1,2,3])
myArr2 = MyArray.new([1,2,3,4])

puts myArr1 <=> myArr2

