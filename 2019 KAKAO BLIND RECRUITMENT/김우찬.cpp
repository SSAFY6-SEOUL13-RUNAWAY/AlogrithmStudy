#include <iostream>
#include <string>
#include <string.h>
#include <cstring>
#include <vector>
#include <tuple>
#include <map>

using namespace std;

vector<string> solution(vector<string> record) {
    vector<string> answer;
    
    vector<tuple<string, vector<int>, string>> user;
    vector<pair<string, string>> log;
    
    for(int i = 0; i < record.size(); i++){
        vector<string> orders;
        char* c_temp = strtok((char*)record[i].c_str(), " ");
        while(c_temp){
            orders.push_back(c_temp);
            c_temp = strtok(NULL, " ");
        }
        
        string order = orders[0];
        string id = orders[1];
        string name = "";
        if(orders.size() == 3)
            name += orders[2];
        
        int user_num = -1;
        for(int j = 0; j < user.size(); j++){
            if(get<0>(user[j]) == id){
                user_num = j;
                break;
            }
        }
        
        if(user_num != -1){
            if(order == "Change" || order == "Enter"){
                if(name != "")
                    get<2>(user[user_num]) = name;
                else
                    get<2>(user[user_num]) = id;
            }
            
            if(order != "Change")
                (get<1>(user[user_num])).push_back(i);
        }
        else{
            vector<int> temp_list;
            string temp_name = "";
            if(order == "Change" || order == "Enter"){
                if(name != "")
                    temp_name = name;
                else
                    temp_name = id;
            }
            
            if(order != "Change")
                temp_list.push_back(i);
    
            user.push_back(make_tuple(id, temp_list, temp_name));
        }
        
        log.push_back(make_pair(order, name));
    }
    
    for(int i = 0; i < user.size(); i++){
        if(get<2>(user[i]) != ""){
            for(int j = 0; j < (get<1>(user[i])).size(); j++){
                log[get<1>(user[i])[j]].second = get<2>(user[i]);
            }
        }
    }
    
    for(int i = 0; i < log.size(); i++){
        string temp = "";
        temp += log[i].second;
        temp += "님이 ";
        
        if(get<0>(log[i]) == "Change")
            continue;
        else if(get<0>(log[i]) == "Enter")
            temp += "들어왔습니다.";
        else if(get<0>(log[i]) == "Leave")
            temp += "나갔습니다.";
        answer.push_back(temp);
    }
    
    return answer;
}
