#include <iostream>

namespace cJSON
{
    void readJSON(std::string data){
        data.erase(std::remove(data.begin(), data.end(), '\n'), data.cend());
        for(int i = 0 ; i< data.size(); i ++){
            if(data[i] == ' ') continue;
            std::cout<<i<<data[i]<<std::endl;
        }
    }

} 
