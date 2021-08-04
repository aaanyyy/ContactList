package Services;

import Models.Contact;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class InMemoryContactService implements ContactService{
    private final List<Contact> contacts;

    @Override
    public List<Contact> getAll() {
        return contacts;
    }

    @Override
    public boolean remove(int id) {

        for (int i=0;i<contacts.size();i++) {
            if(contacts.get(i).getId().equals(id)) {
                contacts.remove(i);
                return true;
            }

        }

        return false;
    }

    @Override
    public void add(Contact contact) {
        if(contact==null)
        {
            throw new UnsupportedOperationException();
        }
        Integer maxId=0;
        if(contacts.size()>0){
            maxId=contacts.get(0).getId();
            for (Contact contact1 : contacts)
                if (contact1.getId() > maxId)
                    maxId = contact1.getId();
        }
        contact.setId(maxId+1);
        contacts.add(contact);
    }
    private Contact get(Integer id)
    {
        for (Contact contact : contacts) {
            if(contact.getId().equals(id))
                return contact;
            }
        return null;
    }

    @Override
    public List<Contact> search(String nameStartsWith) {
        List<Contact> result=new ArrayList<Contact>();
        for (Contact contact : contacts) {
            if(contact.getName().startsWith(nameStartsWith))
                result.add(contact);
        }
        return result;
    }

}
