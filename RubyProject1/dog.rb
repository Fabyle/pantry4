#-------------------------------------------------------
# DEFINITION DE LA CLASSE : DOG
#-------------------------------------------------------
class Dog
  @@classVar = 1000
  @myName
  @myRace
  
   #attr_reader :myName, :myRace
   #attr_writer :myName, :myRace
   attr_accessor :myName, :myRace
  
  # constructeur
  def initialize ( aName, aRace)
    @myName = aName
    @myRace = aRace    
  end
  
#  def set_name( aName )
#    @myName = aName
#  end  
  
# def get_name()
#   return @myName
# end
 
end










