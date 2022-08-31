package phoneAgenda;

import java.util.ArrayList;

public class Agenda {

    private ArrayList<Person> agendContent = new ArrayList<>();

    /*
    this methdo should add a created person in agenda
    minimal checks should be don
        1. p has name
        2. p has phone number
    If one field is not defined, a message should be displayed and person is not added in agenda.
    Before adding the person in agenda, check that the number and name does not exists
     */
    public void addNumberInAgenda(Person p) {
        if (agendContent.size() == 0) {
            agendContent.add(p);
            System.out.println(p);
        } else {
            for (int i = 0; i < agendContent.size(); i++) {
                if (p.getName().equals(agendContent.get(i).getName()) && p.getPhoneNumber().equals(agendContent.get(i).getPhoneNumber())) {
                    System.out.println("This person already exist");
                    break;
                } else {
                    if (i == agendContent.size() - 1) {
                        agendContent.add(p);
                        System.out.println(p);
                        break;
                    }
                }
            }
        }
    }

    /*
    Remove a person from agenda
    Minimal checks made for the person to be removed
        1. p has name
        2. p has phone number
     */
    public void removePersonFromAgenda(Person p) {
        for (int i = 0; i < agendContent.size(); i++) {
            if (p.getName().equals(agendContent.get(i).getName()) && p.getPhoneNumber().equals(agendContent.get(i).getPhoneNumber())) {
                agendContent.remove(i);
                System.out.println(p + " is removed");
                break;
            }
        }

    }

    /*
    Those 2 parameters represents:
        phoneNumber -- phone number of the person to whom we want to update the name
        name -- name that we want to use to update the name of the
     */
    public void updatePhoneNumberInAgenda(String phoneNumeber, String name) {
        for (int i = 0; i < agendContent.size(); i++) {
            if (agendContent.get(i).getName().equals(name)) {
                System.out.println("Numar vechi " + agendContent.get(i));
                agendContent.get(i).setPhoneNumber(phoneNumeber);
                System.out.println("Numar nou " + agendContent.get(i));
            }
        }

    }

    public void updateNameOfPersonFromAgenda(String phoneNumeber, String nameToUpdate) {
        for (int i = 0; i < agendContent.size(); i++) {
            if (agendContent.get(i).getPhoneNumber().equals(phoneNumeber)) {
                System.out.println("Nume vechi " + agendContent.get(i));
                agendContent.get(i).setName(nameToUpdate);
                System.out.println("Nume nou " + agendContent.get(i));
            }
        }
    }

    /*
    Return a NEW array list, that contains the agenda sorted by name
     */
    public ArrayList<Person> getAgendaSortedByName() {
        for (int i = 0; i < agendContent.size(); i++) {
            for (int j = i + 1; j < agendContent.size(); j++) {
                int a = agendContent.get(i).getName().compareTo(agendContent.get(j).getName());
                if (a > 0) {
                    Person temp = new Person();
                    temp = agendContent.get(i);
                    agendContent.set(i, agendContent.get(j));
                    agendContent.set(j, temp);
                }
            }
        }

        return agendContent;
    }

    public ArrayList<Person> getAgendContent() {
        return this.agendContent;
    }

    public void setAgendContent(ArrayList<Person> agendContent) {
        this.agendContent = agendContent;
    }

}
